using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using CustomStateMachine;

public class ExampleStateMachineController : StateMachineController<ExampleBehaviour, ExampleStateMachineController.States>
{
    public override void RegisterStates()
    {
        AddState(new ExampleStateA(this), States.StateA);
        AddState(new ExampleStateB(this), States.StateB);
        AddState(new ExampleStateC(this), States.StateC);
        
    }
    public enum States
    {
        StateA,
        StateB,
        StateC,
    }
}