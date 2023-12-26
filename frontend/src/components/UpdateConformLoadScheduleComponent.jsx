import React, { Component } from 'react'
import ConformLoadScheduleService from '../services/ConformLoadScheduleService';

class UpdateConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConformLoadSchedule = this.updateConformLoadSchedule.bind(this);

    }

    componentDidMount(){
        ConformLoadScheduleService.getConformLoadScheduleById(this.state.id).then( (res) =>{
            let conformLoadSchedule = res.data;
            this.setState({
            });
        });
    }

    updateConformLoadSchedule = (e) => {
        e.preventDefault();
        let conformLoadSchedule = {
            conformLoadScheduleId: this.state.id,
        };
        console.log('conformLoadSchedule => ' + JSON.stringify(conformLoadSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConformLoadScheduleService.updateConformLoadSchedule(conformLoadSchedule).then( res => {
            this.props.history.push('/conformLoadSchedules');
        });
    }


    cancel(){
        this.props.history.push('/conformLoadSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConformLoadSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConformLoadSchedule}>Save</button>
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

export default UpdateConformLoadScheduleComponent
