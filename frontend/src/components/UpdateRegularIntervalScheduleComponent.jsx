import React, { Component } from 'react'
import RegularIntervalScheduleService from '../services/RegularIntervalScheduleService';

class UpdateRegularIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                endTime: '',
                timeStep: ''
        }
        this.updateRegularIntervalSchedule = this.updateRegularIntervalSchedule.bind(this);

        this.changeendTimeHandler = this.changeendTimeHandler.bind(this);
        this.changetimeStepHandler = this.changetimeStepHandler.bind(this);
    }

    componentDidMount(){
        RegularIntervalScheduleService.getRegularIntervalScheduleById(this.state.id).then( (res) =>{
            let regularIntervalSchedule = res.data;
            this.setState({
                endTime: regularIntervalSchedule.endTime,
                timeStep: regularIntervalSchedule.timeStep
            });
        });
    }

    updateRegularIntervalSchedule = (e) => {
        e.preventDefault();
        let regularIntervalSchedule = {
            regularIntervalScheduleId: this.state.id,
            endTime: this.state.endTime,
            timeStep: this.state.timeStep
        };
        console.log('regularIntervalSchedule => ' + JSON.stringify(regularIntervalSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        RegularIntervalScheduleService.updateRegularIntervalSchedule(regularIntervalSchedule).then( res => {
            this.props.history.push('/regularIntervalSchedules');
        });
    }

    changeendTimeHandler= (event) => {
        this.setState({endTime: event.target.value});
    }
    changetimeStepHandler= (event) => {
        this.setState({timeStep: event.target.value});
    }

    cancel(){
        this.props.history.push('/regularIntervalSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RegularIntervalSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> endTime: </label>
                                            #formFields( $attribute, 'update')
                                            <label> timeStep: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRegularIntervalSchedule}>Save</button>
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

export default UpdateRegularIntervalScheduleComponent
