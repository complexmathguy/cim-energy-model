import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService';

class CreateRotatingMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                damping: '',
                inertia: '',
                saturationFactor: '',
                saturationFactor120: '',
                statorLeakageReactance: '',
                statorResistance: ''
        }
        this.changedampingHandler = this.changedampingHandler.bind(this);
        this.changeinertiaHandler = this.changeinertiaHandler.bind(this);
        this.changesaturationFactorHandler = this.changesaturationFactorHandler.bind(this);
        this.changesaturationFactor120Handler = this.changesaturationFactor120Handler.bind(this);
        this.changestatorLeakageReactanceHandler = this.changestatorLeakageReactanceHandler.bind(this);
        this.changestatorResistanceHandler = this.changestatorResistanceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RotatingMachineDynamicsService.getRotatingMachineDynamicsById(this.state.id).then( (res) =>{
                let rotatingMachineDynamics = res.data;
                this.setState({
                    damping: rotatingMachineDynamics.damping,
                    inertia: rotatingMachineDynamics.inertia,
                    saturationFactor: rotatingMachineDynamics.saturationFactor,
                    saturationFactor120: rotatingMachineDynamics.saturationFactor120,
                    statorLeakageReactance: rotatingMachineDynamics.statorLeakageReactance,
                    statorResistance: rotatingMachineDynamics.statorResistance
                });
            });
        }        
    }
    saveOrUpdateRotatingMachineDynamics = (e) => {
        e.preventDefault();
        let rotatingMachineDynamics = {
                rotatingMachineDynamicsId: this.state.id,
                damping: this.state.damping,
                inertia: this.state.inertia,
                saturationFactor: this.state.saturationFactor,
                saturationFactor120: this.state.saturationFactor120,
                statorLeakageReactance: this.state.statorLeakageReactance,
                statorResistance: this.state.statorResistance
            };
        console.log('rotatingMachineDynamics => ' + JSON.stringify(rotatingMachineDynamics));

        // step 5
        if(this.state.id === '_add'){
            rotatingMachineDynamics.rotatingMachineDynamicsId=''
            RotatingMachineDynamicsService.createRotatingMachineDynamics(rotatingMachineDynamics).then(res =>{
                this.props.history.push('/rotatingMachineDynamicss');
            });
        }else{
            RotatingMachineDynamicsService.updateRotatingMachineDynamics(rotatingMachineDynamics).then( res => {
                this.props.history.push('/rotatingMachineDynamicss');
            });
        }
    }
    
    changedampingHandler= (event) => {
        this.setState({damping: event.target.value});
    }
    changeinertiaHandler= (event) => {
        this.setState({inertia: event.target.value});
    }
    changesaturationFactorHandler= (event) => {
        this.setState({saturationFactor: event.target.value});
    }
    changesaturationFactor120Handler= (event) => {
        this.setState({saturationFactor120: event.target.value});
    }
    changestatorLeakageReactanceHandler= (event) => {
        this.setState({statorLeakageReactance: event.target.value});
    }
    changestatorResistanceHandler= (event) => {
        this.setState({statorResistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/rotatingMachineDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RotatingMachineDynamics</h3>
        }else{
            return <h3 className="text-center">Update RotatingMachineDynamics</h3>
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
                                            <label> damping: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inertia: </label>
                                            #formFields( $attribute, 'create')
                                            <label> saturationFactor: </label>
                                            #formFields( $attribute, 'create')
                                            <label> saturationFactor120: </label>
                                            #formFields( $attribute, 'create')
                                            <label> statorLeakageReactance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> statorResistance: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRotatingMachineDynamics}>Save</button>
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

export default CreateRotatingMachineDynamicsComponent
