import React, { Component } from 'react'
import RegulationScheduleService from '../services/RegulationScheduleService';

class UpdateRegulationScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRegulationSchedule = this.updateRegulationSchedule.bind(this);

    }

    componentDidMount(){
        RegulationScheduleService.getRegulationScheduleById(this.state.id).then( (res) =>{
            let regulationSchedule = res.data;
            this.setState({
            });
        });
    }

    updateRegulationSchedule = (e) => {
        e.preventDefault();
        let regulationSchedule = {
            regulationScheduleId: this.state.id,
        };
        console.log('regulationSchedule => ' + JSON.stringify(regulationSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        RegulationScheduleService.updateRegulationSchedule(regulationSchedule).then( res => {
            this.props.history.push('/regulationSchedules');
        });
    }


    cancel(){
        this.props.history.push('/regulationSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RegulationSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRegulationSchedule}>Save</button>
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

export default UpdateRegulationScheduleComponent
