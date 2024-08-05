using CustomStateMachine;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ExampleStateC : ExampleStateBehaviour
{
    public ExampleStateC(ExampleStateMachineController stateMachineController) : base(stateMachineController)
    {
    }

    public override void OnStateRegistered()
    {
        throw new System.NotImplementedException();
    }

    public override void OnStateActivated()
    {
        throw new System.NotImplementedException();
    }

    public override void Update()
    {
        throw new System.NotImplementedException();
    }

    public override void OnStateDisabled()
    {
        throw new System.NotImplementedException();
    }

}