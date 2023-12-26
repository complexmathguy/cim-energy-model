import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService';

class UpdateRotatingMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                damping: '',
                inertia: '',
                saturationFactor: '',
                saturationFactor120: '',
                statorLeakageReactance: '',
                statorResistance: ''
        }
        this.updateRotatingMachineDynamics = this.updateRotatingMachineDynamics.bind(this);

        this.changedampingHandler = this.changedampingHandler.bind(this);
        this.changeinertiaHandler = this.changeinertiaHandler.bind(this);
        this.changesaturationFactorHandler = this.changesaturationFactorHandler.bind(this);
        this.changesaturationFactor120Handler = this.changesaturationFactor120Handler.bind(this);
        this.changestatorLeakageReactanceHandler = this.changestatorLeakageReactanceHandler.bind(this);
        this.changestatorResistanceHandler = this.changestatorResistanceHandler.bind(this);
    }

    componentDidMount(){
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

    updateRotatingMachineDynamics = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        RotatingMachineDynamicsService.updateRotatingMachineDynamics(rotatingMachineDynamics).then( res => {
            this.props.history.push('/rotatingMachineDynamicss');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RotatingMachineDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> damping: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inertia: </label>
                                            #formFields( $attribute, 'update')
                                            <label> saturationFactor: </label>
                                            #formFields( $attribute, 'update')
                                            <label> saturationFactor120: </label>
                                            #formFields( $attribute, 'update')
                                            <label> statorLeakageReactance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> statorResistance: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRotatingMachineDynamics}>Save</button>
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

export default UpdateRotatingMachineDynamicsComponent
