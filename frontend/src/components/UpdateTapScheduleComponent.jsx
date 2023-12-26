import React, { Component } from 'react'
import TapScheduleService from '../services/TapScheduleService';

class UpdateTapScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTapSchedule = this.updateTapSchedule.bind(this);

    }

    componentDidMount(){
        TapScheduleService.getTapScheduleById(this.state.id).then( (res) =>{
            let tapSchedule = res.data;
            this.setState({
            });
        });
    }

    updateTapSchedule = (e) => {
        e.preventDefault();
        let tapSchedule = {
            tapScheduleId: this.state.id,
        };
        console.log('tapSchedule => ' + JSON.stringify(tapSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        TapScheduleService.updateTapSchedule(tapSchedule).then( res => {
            this.props.history.push('/tapSchedules');
        });
    }


    cancel(){
        this.props.history.push('/tapSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapSchedule}>Save</button>
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

export default UpdateTapScheduleComponent
