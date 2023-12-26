import React, { Component } from 'react'
import RotatingMachineService from '../services/RotatingMachineService';

class CreateRotatingMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ratedPowerFactor: '',
                ratedS: '',
                ratedU: ''
        }
        this.changeratedPowerFactorHandler = this.changeratedPowerFactorHandler.bind(this);
        this.changeratedSHandler = this.changeratedSHandler.bind(this);
        this.changeratedUHandler = this.changeratedUHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RotatingMachineService.getRotatingMachineById(this.state.id).then( (res) =>{
                let rotatingMachine = res.data;
                this.setState({
                    ratedPowerFactor: rotatingMachine.ratedPowerFactor,
                    ratedS: rotatingMachine.ratedS,
                    ratedU: rotatingMachine.ratedU
                });
            });
        }        
    }
    saveOrUpdateRotatingMachine = (e) => {
        e.preventDefault();
        let rotatingMachine = {
                rotatingMachineId: this.state.id,
                ratedPowerFactor: this.state.ratedPowerFactor,
                ratedS: this.state.ratedS,
                ratedU: this.state.ratedU
            };
        console.log('rotatingMachine => ' + JSON.stringify(rotatingMachine));

        // step 5
        if(this.state.id === '_add'){
            rotatingMachine.rotatingMachineId=''
            RotatingMachineService.createRotatingMachine(rotatingMachine).then(res =>{
                this.props.history.push('/rotatingMachines');
            });
        }else{
            RotatingMachineService.updateRotatingMachine(rotatingMachine).then( res => {
                this.props.history.push('/rotatingMachines');
            });
        }
    }
    
    changeratedPowerFactorHandler= (event) => {
        this.setState({ratedPowerFactor: event.target.value});
    }
    changeratedSHandler= (event) => {
        this.setState({ratedS: event.target.value});
    }
    changeratedUHandler= (event) => {
        this.setState({ratedU: event.target.value});
    }

    cancel(){
        this.props.history.push('/rotatingMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RotatingMachine</h3>
        }else{
            return <h3 className="text-center">Update RotatingMachine</h3>
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
                                            <label> ratedPowerFactor: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedS: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedU: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRotatingMachine}>Save</button>
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

export default CreateRotatingMachineComponent
