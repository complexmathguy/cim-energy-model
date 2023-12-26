import React, { Component } from 'react'
import ControlService from '../services/ControlService';

class UpdateControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                controlType: '',
                operationInProgress: '',
                timeStamp: '',
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.updateControl = this.updateControl.bind(this);

        this.changecontrolTypeHandler = this.changecontrolTypeHandler.bind(this);
        this.changeoperationInProgressHandler = this.changeoperationInProgressHandler.bind(this);
        this.changetimeStampHandler = this.changetimeStampHandler.bind(this);
        this.changeunitMultiplierHandler = this.changeunitMultiplierHandler.bind(this);
        this.changeunitSymbolHandler = this.changeunitSymbolHandler.bind(this);
    }

    componentDidMount(){
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

    updateControl = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        ControlService.updateControl(control).then( res => {
            this.props.history.push('/controls');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Control</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> controlType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> operationInProgress: </label>
                                            #formFields( $attribute, 'update')
                                            <label> timeStamp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unitMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unitSymbol: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateControl}>Save</button>
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

export default UpdateControlComponent
