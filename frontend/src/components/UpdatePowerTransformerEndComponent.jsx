import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService';

class UpdatePowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b: '',
                b0: '',
                connectionKind: '',
                g: '',
                g0: '',
                phaseAngleClock: '',
                r: '',
                r0: '',
                ratedS: '',
                ratedU: '',
                x: '',
                x0: ''
        }
        this.updatePowerTransformerEnd = this.updatePowerTransformerEnd.bind(this);

        this.changebHandler = this.changebHandler.bind(this);
        this.changeb0Handler = this.changeb0Handler.bind(this);
        this.changeconnectionKindHandler = this.changeconnectionKindHandler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
        this.changeg0Handler = this.changeg0Handler.bind(this);
        this.changephaseAngleClockHandler = this.changephaseAngleClockHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changeratedSHandler = this.changeratedSHandler.bind(this);
        this.changeratedUHandler = this.changeratedUHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEndById(this.state.id).then( (res) =>{
            let powerTransformerEnd = res.data;
            this.setState({
                b: powerTransformerEnd.b,
                b0: powerTransformerEnd.b0,
                connectionKind: powerTransformerEnd.connectionKind,
                g: powerTransformerEnd.g,
                g0: powerTransformerEnd.g0,
                phaseAngleClock: powerTransformerEnd.phaseAngleClock,
                r: powerTransformerEnd.r,
                r0: powerTransformerEnd.r0,
                ratedS: powerTransformerEnd.ratedS,
                ratedU: powerTransformerEnd.ratedU,
                x: powerTransformerEnd.x,
                x0: powerTransformerEnd.x0
            });
        });
    }

    updatePowerTransformerEnd = (e) => {
        e.preventDefault();
        let powerTransformerEnd = {
            powerTransformerEndId: this.state.id,
            b: this.state.b,
            b0: this.state.b0,
            connectionKind: this.state.connectionKind,
            g: this.state.g,
            g0: this.state.g0,
            phaseAngleClock: this.state.phaseAngleClock,
            r: this.state.r,
            r0: this.state.r0,
            ratedS: this.state.ratedS,
            ratedU: this.state.ratedU,
            x: this.state.x,
            x0: this.state.x0
        };
        console.log('powerTransformerEnd => ' + JSON.stringify(powerTransformerEnd));
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerTransformerEndService.updatePowerTransformerEnd(powerTransformerEnd).then( res => {
            this.props.history.push('/powerTransformerEnds');
        });
    }

    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changeb0Handler= (event) => {
        this.setState({b0: event.target.value});
    }
    changeconnectionKindHandler= (event) => {
        this.setState({connectionKind: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }
    changeg0Handler= (event) => {
        this.setState({g0: event.target.value});
    }
    changephaseAngleClockHandler= (event) => {
        this.setState({phaseAngleClock: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changeratedSHandler= (event) => {
        this.setState({ratedS: event.target.value});
    }
    changeratedUHandler= (event) => {
        this.setState({ratedU: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }

    cancel(){
        this.props.history.push('/powerTransformerEnds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerTransformerEnd</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> b0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> connectionKind: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> phaseAngleClock: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedS: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedU: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerTransformerEnd}>Save</button>
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

export default UpdatePowerTransformerEndComponent
