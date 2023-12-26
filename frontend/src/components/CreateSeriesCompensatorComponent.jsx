import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService';

class CreateSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                r: '',
                r0: '',
                varistorPresent: '',
                varistorRatedCurrent: '',
                varistorVoltageThreshold: '',
                x: '',
                x0: ''
        }
        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changevaristorPresentHandler = this.changevaristorPresentHandler.bind(this);
        this.changevaristorRatedCurrentHandler = this.changevaristorRatedCurrentHandler.bind(this);
        this.changevaristorVoltageThresholdHandler = this.changevaristorVoltageThresholdHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateSeriesCompensator = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            seriesCompensator.seriesCompensatorId=''
            SeriesCompensatorService.createSeriesCompensator(seriesCompensator).then(res =>{
                this.props.history.push('/seriesCompensators');
            });
        }else{
            SeriesCompensatorService.updateSeriesCompensator(seriesCompensator).then( res => {
                this.props.history.push('/seriesCompensators');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SeriesCompensator</h3>
        }else{
            return <h3 className="text-center">Update SeriesCompensator</h3>
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
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> varistorPresent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> varistorRatedCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> varistorVoltageThreshold: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSeriesCompensator}>Save</button>
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

export default CreateSeriesCompensatorComponent
