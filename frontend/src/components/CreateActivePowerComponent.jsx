import React, { Component } from 'react'
import ActivePowerService from '../services/ActivePowerService';

class CreateActivePowerComponent extends Component {
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
            ActivePowerService.getActivePowerById(this.state.id).then( (res) =>{
                let activePower = res.data;
                this.setState({
                    multiplier: activePower.multiplier,
                    unit: activePower.unit,
                    value: activePower.value
                });
            });
        }        
    }
    saveOrUpdateActivePower = (e) => {
        e.preventDefault();
        let activePower = {
                activePowerId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('activePower => ' + JSON.stringify(activePower));

        // step 5
        if(this.state.id === '_add'){
            activePower.activePowerId=''
            ActivePowerService.createActivePower(activePower).then(res =>{
                this.props.history.push('/activePowers');
            });
        }else{
            ActivePowerService.updateActivePower(activePower).then( res => {
                this.props.history.push('/activePowers');
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
        this.props.history.push('/activePowers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ActivePower</h3>
        }else{
            return <h3 className="text-center">Update ActivePower</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateActivePower}>Save</button>
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

export default CreateActivePowerComponent
