import React, { Component } from 'react'
import StaticVarCompensatorService from '../services/StaticVarCompensatorService';

class UpdateStaticVarCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                capacitiveRating: '',
                inductiveRating: '',
                slope: '',
                sVCControlMode: '',
                voltageSetPoint: ''
        }
        this.updateStaticVarCompensator = this.updateStaticVarCompensator.bind(this);

        this.changecapacitiveRatingHandler = this.changecapacitiveRatingHandler.bind(this);
        this.changeinductiveRatingHandler = this.changeinductiveRatingHandler.bind(this);
        this.changeslopeHandler = this.changeslopeHandler.bind(this);
        this.changesVCControlModeHandler = this.changesVCControlModeHandler.bind(this);
        this.changevoltageSetPointHandler = this.changevoltageSetPointHandler.bind(this);
    }

    componentDidMount(){
        StaticVarCompensatorService.getStaticVarCompensatorById(this.state.id).then( (res) =>{
            let staticVarCompensator = res.data;
            this.setState({
                capacitiveRating: staticVarCompensator.capacitiveRating,
                inductiveRating: staticVarCompensator.inductiveRating,
                slope: staticVarCompensator.slope,
                sVCControlMode: staticVarCompensator.sVCControlMode,
                voltageSetPoint: staticVarCompensator.voltageSetPoint
            });
        });
    }

    updateStaticVarCompensator = (e) => {
        e.preventDefault();
        let staticVarCompensator = {
            staticVarCompensatorId: this.state.id,
            capacitiveRating: this.state.capacitiveRating,
            inductiveRating: this.state.inductiveRating,
            slope: this.state.slope,
            sVCControlMode: this.state.sVCControlMode,
            voltageSetPoint: this.state.voltageSetPoint
        };
        console.log('staticVarCompensator => ' + JSON.stringify(staticVarCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        StaticVarCompensatorService.updateStaticVarCompensator(staticVarCompensator).then( res => {
            this.props.history.push('/staticVarCompensators');
        });
    }

    changecapacitiveRatingHandler= (event) => {
        this.setState({capacitiveRating: event.target.value});
    }
    changeinductiveRatingHandler= (event) => {
        this.setState({inductiveRating: event.target.value});
    }
    changeslopeHandler= (event) => {
        this.setState({slope: event.target.value});
    }
    changesVCControlModeHandler= (event) => {
        this.setState({sVCControlMode: event.target.value});
    }
    changevoltageSetPointHandler= (event) => {
        this.setState({voltageSetPoint: event.target.value});
    }

    cancel(){
        this.props.history.push('/staticVarCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StaticVarCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> capacitiveRating: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inductiveRating: </label>
                                            #formFields( $attribute, 'update')
                                            <label> slope: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sVCControlMode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> voltageSetPoint: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStaticVarCompensator}>Save</button>
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

export default UpdateStaticVarCompensatorComponent
