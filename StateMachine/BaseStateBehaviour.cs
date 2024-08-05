using UnityEngine;

namespace CustomStateMachine
{
    public abstract class BaseStateBehaviour
    {
        public abstract void OnStateRegistered();
        public abstract void OnStateActivated();
        public abstract void Update();
        public virtual void OnTriggerEnter(Collider other) { }
        public virtual void OnTriggerExit(Collider other) { }
        public abstract void OnStateDisabled();
    }
}
