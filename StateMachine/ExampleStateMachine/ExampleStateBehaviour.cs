using CustomStateMachine;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public abstract class ExampleStateBehaviour : StateBehaviour<ExampleStateMachineController>
{
    public ExampleStateBehaviour(ExampleStateMachineController stateMachineController) : base(stateMachineController)
    {
    }
}
