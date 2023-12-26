import React, { Component } from 'react'
import CurrentFlowService from '../services/CurrentFlowService';

class CreateCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CurrentFlowService.getCurrentFlowById(this.state.id).then( (res) =>{
                let currentFlow = res.data;
                this.setState({
                    multiplier: currentFlow.multiplier,
                    unit: currentFlow.unit,
                    value: currentFlow.value
                });
            });
        }        
    }
    saveOrUpdateCurrentFlow = (e) => {
        e.preventDefault();
        let currentFlow = {
                currentFlowId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('currentFlow => ' + JSON.stringify(currentFlow));

        // step 5
        if(this.state.id === '_add'){
            currentFlow.currentFlowId=''
            CurrentFlowService.createCurrentFlow(currentFlow).then(res =>{
                this.props.history.push('/currentFlows');
            });
        }else{
            CurrentFlowService.updateCurrentFlow(currentFlow).then( res => {
                this.props.history.push('/currentFlows');
            });
        }
    }
    
    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/currentFlows');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CurrentFlow</h3>
        }else{
            return <h3 className="text-center">Update CurrentFlow</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCurrentFlow}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateCurrentFlowComponent
