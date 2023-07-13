package com.demo.javaconcepts.multithreading.problems;

import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LiveLockDemo {

    public static void main(String[] args) {
        PhoneCall p1 = new PhoneCall("p1");
        PhoneCall p2 = new PhoneCall("p2");
        HangUpAction hangUpAction = new HangUpAction(p1);

        new Thread(() -> p1.hangUpWith(hangUpAction, p2)).start();
        new Thread(() -> p2.hangUpWith(hangUpAction, p1)).start();
    }

    private static class HangUpAction {
        private PhoneCall caller;

        public HangUpAction(PhoneCall caller) {
            this.caller = caller;
        }

        public void setCaller(PhoneCall caller) {
            this.caller = caller;
        }

        public void end() {
            log.info("{} has ended call!", caller.name);
        }
    }

    private static class PhoneCall {
        private final String name;

        private boolean isDone;

        public PhoneCall(String name) {
            this.name = name;
        }
        public void hangUpWith(HangUpAction hangUpAction, PhoneCall buddy) {
            while (!isDone) {
                if (hangUpAction.caller != this) {
                    DateTimeUtils.sleepMs(1000);
                    continue;
                }
                if (!buddy.isDone) {
                    log.info("{}: No you hang up: {}", name, buddy.name);
                    hangUpAction.setCaller(buddy);
                    continue;
                }
                hangUpAction.end();
                buddy.isDone = true;
                isDone = true;
            }
        }
    }
}
