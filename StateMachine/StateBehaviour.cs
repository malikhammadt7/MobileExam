using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace CustomStateMachine
{
    public abstract class StateBehaviour<T> : BaseStateBehaviour
    {
        public T StateMachineController => stateMachineController;
        protected T stateMachineController;

        public StateBehaviour(T stateMachineController): base()
        {
            this.stateMachineController = stateMachineController;
        }
    }
}