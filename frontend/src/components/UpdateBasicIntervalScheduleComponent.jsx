import React, { Component } from 'react'
import BasicIntervalScheduleService from '../services/BasicIntervalScheduleService';

class UpdateBasicIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                startTime: '',
                value1Unit: '',
                value2Unit: ''
        }
        this.updateBasicIntervalSchedule = this.updateBasicIntervalSchedule.bind(this);

        this.changestartTimeHandler = this.changestartTimeHandler.bind(this);
        this.changevalue1UnitHandler = this.changevalue1UnitHandler.bind(this);
        this.changevalue2UnitHandler = this.changevalue2UnitHandler.bind(this);
    }

    componentDidMount(){
        BasicIntervalScheduleService.getBasicIntervalScheduleById(this.state.id).then( (res) =>{
            let basicIntervalSchedule = res.data;
            this.setState({
                startTime: basicIntervalSchedule.startTime,
                value1Unit: basicIntervalSchedule.value1Unit,
                value2Unit: basicIntervalSchedule.value2Unit
            });
        });
    }

    updateBasicIntervalSchedule = (e) => {
        e.preventDefault();
        let basicIntervalSchedule = {
            basicIntervalScheduleId: this.state.id,
            startTime: this.state.startTime,
            value1Unit: this.state.value1Unit,
            value2Unit: this.state.value2Unit
        };
        console.log('basicIntervalSchedule => ' + JSON.stringify(basicIntervalSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        BasicIntervalScheduleService.updateBasicIntervalSchedule(basicIntervalSchedule).then( res => {
            this.props.history.push('/basicIntervalSchedules');
        });
    }

    changestartTimeHandler= (event) => {
        this.setState({startTime: event.target.value});
    }
    changevalue1UnitHandler= (event) => {
        this.setState({value1Unit: event.target.value});
    }
    changevalue2UnitHandler= (event) => {
        this.setState({value2Unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/basicIntervalSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BasicIntervalSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> startTime: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value1Unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value2Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBasicIntervalSchedule}>Save</button>
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

export default UpdateBasicIntervalScheduleComponent
