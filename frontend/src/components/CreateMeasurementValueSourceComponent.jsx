import React, { Component } from 'react'
import MeasurementValueSourceService from '../services/MeasurementValueSourceService';

class CreateMeasurementValueSourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MeasurementValueSourceService.getMeasurementValueSourceById(this.state.id).then( (res) =>{
                let measurementValueSource = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMeasurementValueSource = (e) => {
        e.preventDefault();
        let measurementValueSource = {
                measurementValueSourceId: this.state.id,
            };
        console.log('measurementValueSource => ' + JSON.stringify(measurementValueSource));

        // step 5
        if(this.state.id === '_add'){
            measurementValueSource.measurementValueSourceId=''
            MeasurementValueSourceService.createMeasurementValueSource(measurementValueSource).then(res =>{
                this.props.history.push('/measurementValueSources');
            });
        }else{
            MeasurementValueSourceService.updateMeasurementValueSource(measurementValueSource).then( res => {
                this.props.history.push('/measurementValueSources');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/measurementValueSources');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MeasurementValueSource</h3>
        }else{
            return <h3 className="text-center">Update MeasurementValueSource</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMeasurementValueSource}>Save</button>
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

export default CreateMeasurementValueSourceComponent
