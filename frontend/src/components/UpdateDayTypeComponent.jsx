import React, { Component } from 'react'
import DayTypeService from '../services/DayTypeService';

class UpdateDayTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDayType = this.updateDayType.bind(this);

    }

    componentDidMount(){
        DayTypeService.getDayTypeById(this.state.id).then( (res) =>{
            let dayType = res.data;
            this.setState({
            });
        });
    }

    updateDayType = (e) => {
        e.preventDefault();
        let dayType = {
            dayTypeId: this.state.id,
        };
        console.log('dayType => ' + JSON.stringify(dayType));
        console.log('id => ' + JSON.stringify(this.state.id));
        DayTypeService.updateDayType(dayType).then( res => {
            this.props.history.push('/dayTypes');
        });
    }


    cancel(){
        this.props.history.push('/dayTypes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DayType</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDayType}>Save</button>
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

export default UpdateDayTypeComponent
