public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    /**
     * Contract:
     *   Preconditions  — n != null, n.body != null
     *   Postconditions — returns non-null SendResult, never throws for valid input
     *   Subclass rule  — doSend must not tighten preconditions;
     *                     channel-specific limits return SendResult.failure()
     */
    public final SendResult send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("Notification must not be null");
        }
        if (n.body == null) {
            throw new IllegalArgumentException("body must not be null");
        }

        SendResult result = doSend(n);

        if (result == null) {
            throw new IllegalStateException("doSend must not return null");
        }
        return result;
    }

    protected abstract SendResult doSend(Notification n);
}
