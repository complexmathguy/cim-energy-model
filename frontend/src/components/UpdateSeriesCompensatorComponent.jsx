import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService';

class UpdateSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                r: '',
                r0: '',
                varistorPresent: '',
                varistorRatedCurrent: '',
                varistorVoltageThreshold: '',
                x: '',
                x0: ''
        }
        this.updateSeriesCompensator = this.updateSeriesCompensator.bind(this);

        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changevaristorPresentHandler = this.changevaristorPresentHandler.bind(this);
        this.changevaristorRatedCurrentHandler = this.changevaristorRatedCurrentHandler.bind(this);
        this.changevaristorVoltageThresholdHandler = this.changevaristorVoltageThresholdHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    componentDidMount(){
        SeriesCompensatorService.getSeriesCompensatorById(this.state.id).then( (res) =>{
            let seriesCompensator = res.data;
            this.setState({
                r: seriesCompensator.r,
                r0: seriesCompensator.r0,
                varistorPresent: seriesCompensator.varistorPresent,
                varistorRatedCurrent: seriesCompensator.varistorRatedCurrent,
                varistorVoltageThreshold: seriesCompensator.varistorVoltageThreshold,
                x: seriesCompensator.x,
                x0: seriesCompensator.x0
            });
        });
    }

    updateSeriesCompensator = (e) => {
        e.preventDefault();
        let seriesCompensator = {
            seriesCompensatorId: this.state.id,
            r: this.state.r,
            r0: this.state.r0,
            varistorPresent: this.state.varistorPresent,
            varistorRatedCurrent: this.state.varistorRatedCurrent,
            varistorVoltageThreshold: this.state.varistorVoltageThreshold,
            x: this.state.x,
            x0: this.state.x0
        };
        console.log('seriesCompensator => ' + JSON.stringify(seriesCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        SeriesCompensatorService.updateSeriesCompensator(seriesCompensator).then( res => {
            this.props.history.push('/seriesCompensators');
        });
    }

    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changevaristorPresentHandler= (event) => {
        this.setState({varistorPresent: event.target.value});
    }
    changevaristorRatedCurrentHandler= (event) => {
        this.setState({varistorRatedCurrent: event.target.value});
    }
    changevaristorVoltageThresholdHandler= (event) => {
        this.setState({varistorVoltageThreshold: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }

    cancel(){
        this.props.history.push('/seriesCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SeriesCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> varistorPresent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> varistorRatedCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> varistorVoltageThreshold: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeriesCompensator}>Save</button>
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

export default UpdateSeriesCompensatorComponent
