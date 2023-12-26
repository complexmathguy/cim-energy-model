import React, { Component } from 'react'
import ControlService from '../services/ControlService';

class CreateControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                controlType: '',
                operationInProgress: '',
                timeStamp: '',
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.changecontrolTypeHandler = this.changecontrolTypeHandler.bind(this);
        this.changeoperationInProgressHandler = this.changeoperationInProgressHandler.bind(this);
        this.changetimeStampHandler = this.changetimeStampHandler.bind(this);
        this.changeunitMultiplierHandler = this.changeunitMultiplierHandler.bind(this);
        this.changeunitSymbolHandler = this.changeunitSymbolHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ControlService.getControlById(this.state.id).then( (res) =>{
                let control = res.data;
                this.setState({
                    controlType: control.controlType,
                    operationInProgress: control.operationInProgress,
                    timeStamp: control.timeStamp,
                    unitMultiplier: control.unitMultiplier,
                    unitSymbol: control.unitSymbol
                });
            });
        }        
    }
    saveOrUpdateControl = (e) => {
        e.preventDefault();
        let control = {
                controlId: this.state.id,
                controlType: this.state.controlType,
                operationInProgress: this.state.operationInProgress,
                timeStamp: this.state.timeStamp,
                unitMultiplier: this.state.unitMultiplier,
                unitSymbol: this.state.unitSymbol
            };
        console.log('control => ' + JSON.stringify(control));

        // step 5
        if(this.state.id === '_add'){
            control.controlId=''
            ControlService.createControl(control).then(res =>{
                this.props.history.push('/controls');
            });
        }else{
            ControlService.updateControl(control).then( res => {
                this.props.history.push('/controls');
            });
        }
    }
    
    changecontrolTypeHandler= (event) => {
        this.setState({controlType: event.target.value});
    }
    changeoperationInProgressHandler= (event) => {
        this.setState({operationInProgress: event.target.value});
    }
    changetimeStampHandler= (event) => {
        this.setState({timeStamp: event.target.value});
    }
    changeunitMultiplierHandler= (event) => {
        this.setState({unitMultiplier: event.target.value});
    }
    changeunitSymbolHandler= (event) => {
        this.setState({unitSymbol: event.target.value});
    }

    cancel(){
        this.props.history.push('/controls');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Control</h3>
        }else{
            return <h3 className="text-center">Update Control</h3>
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
                                            <label> controlType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> operationInProgress: </label>
                                            #formFields( $attribute, 'create')
                                            <label> timeStamp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unitMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unitSymbol: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateControl}>Save</button>
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

export default CreateControlComponent
