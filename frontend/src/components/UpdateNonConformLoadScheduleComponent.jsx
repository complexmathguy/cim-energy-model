import React, { Component } from 'react'
import NonConformLoadScheduleService from '../services/NonConformLoadScheduleService';

class UpdateNonConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNonConformLoadSchedule = this.updateNonConformLoadSchedule.bind(this);

    }

    componentDidMount(){
        NonConformLoadScheduleService.getNonConformLoadScheduleById(this.state.id).then( (res) =>{
            let nonConformLoadSchedule = res.data;
            this.setState({
            });
        });
    }

    updateNonConformLoadSchedule = (e) => {
        e.preventDefault();
        let nonConformLoadSchedule = {
            nonConformLoadScheduleId: this.state.id,
        };
        console.log('nonConformLoadSchedule => ' + JSON.stringify(nonConformLoadSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonConformLoadScheduleService.updateNonConformLoadSchedule(nonConformLoadSchedule).then( res => {
            this.props.history.push('/nonConformLoadSchedules');
        });
    }


    cancel(){
        this.props.history.push('/nonConformLoadSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonConformLoadSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonConformLoadSchedule}>Save</button>
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

export default UpdateNonConformLoadScheduleComponent
