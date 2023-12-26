import React, { Component } from 'react'
import SwitchScheduleService from '../services/SwitchScheduleService';

class UpdateSwitchScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSwitchSchedule = this.updateSwitchSchedule.bind(this);

    }

    componentDidMount(){
        SwitchScheduleService.getSwitchScheduleById(this.state.id).then( (res) =>{
            let switchSchedule = res.data;
            this.setState({
            });
        });
    }

    updateSwitchSchedule = (e) => {
        e.preventDefault();
        let switchSchedule = {
            switchScheduleId: this.state.id,
        };
        console.log('switchSchedule => ' + JSON.stringify(switchSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        SwitchScheduleService.updateSwitchSchedule(switchSchedule).then( res => {
            this.props.history.push('/switchSchedules');
        });
    }


    cancel(){
        this.props.history.push('/switchSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SwitchSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSwitchSchedule}>Save</button>
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

export default UpdateSwitchScheduleComponent
