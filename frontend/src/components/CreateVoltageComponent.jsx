import React, { Component } from 'react'
import VoltageService from '../services/VoltageService';

class CreateVoltageComponent extends Component {
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
            VoltageService.getVoltageById(this.state.id).then( (res) =>{
                let voltage = res.data;
                this.setState({
                    multiplier: voltage.multiplier,
                    unit: voltage.unit,
                    value: voltage.value
                });
            });
        }        
    }
    saveOrUpdateVoltage = (e) => {
        e.preventDefault();
        let voltage = {
                voltageId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('voltage => ' + JSON.stringify(voltage));

        // step 5
        if(this.state.id === '_add'){
            voltage.voltageId=''
            VoltageService.createVoltage(voltage).then(res =>{
                this.props.history.push('/voltages');
            });
        }else{
            VoltageService.updateVoltage(voltage).then( res => {
                this.props.history.push('/voltages');
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
        this.props.history.push('/voltages');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Voltage</h3>
        }else{
            return <h3 className="text-center">Update Voltage</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltage}>Save</button>
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

export default CreateVoltageComponent
