using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;

namespace CustomStateMachine
{
    public abstract class StateMachineController<B, S> where B : MonoBehaviour
    {
        public B entityBehaviour => _entityBehaviour;
        private B _entityBehaviour;

        public S currentState => _currentState;
        private S _currentState;

        public BaseStateBehaviour activeStateBehaviour => _activeStateBehaviour;
        private BaseStateBehaviour _activeStateBehaviour;
        
        private List<BaseStateBehaviour> _statesList = new List<BaseStateBehaviour>();
        private Dictionary<S, int> _statesMap = new Dictionary<S, int>();

        public void Initialize(B entityBehaviour, S defaultState)
        {
            this._entityBehaviour = entityBehaviour;
            RegisterStates();
            SwitchStateTo(defaultState);
        }
        public void AddState(BaseStateBehaviour stateBehaviour, S state)
        {
            if (!_statesList.Contains(stateBehaviour) && !_statesMap.ContainsKey(state))
            {
                _statesList.Add(stateBehaviour);
                _statesMap.Add(state, _statesList.Count - 1);
            }
        }
        public void SwitchStateTo(S state)
        {
            BaseStateBehaviour stateBehaviour = _statesList[_statesMap[state]];
            if (_statesList.Contains(stateBehaviour))
            {
                _activeStateBehaviour.OnStateDisabled();

                _currentState = state;
                _activeStateBehaviour = stateBehaviour;

                _activeStateBehaviour.OnStateActivated();
            }
            else
            {
                Debug.LogError("Cannot switch to the specified state. Make sure both current and new states are added.");
            }
        }
        public BaseStateBehaviour GetStateBehaviour(S state)
        {
            return _statesList[_statesMap[state]];
        }

        public abstract void RegisterStates();
    }
}
