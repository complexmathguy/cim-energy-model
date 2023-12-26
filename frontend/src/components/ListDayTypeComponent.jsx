import React, { Component } from 'react'
import DayTypeService from '../services/DayTypeService'

class ListDayTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dayTypes: []
        }
        this.addDayType = this.addDayType.bind(this);
        this.editDayType = this.editDayType.bind(this);
        this.deleteDayType = this.deleteDayType.bind(this);
    }

    deleteDayType(id){
        DayTypeService.deleteDayType(id).then( res => {
            this.setState({dayTypes: this.state.dayTypes.filter(dayType => dayType.dayTypeId !== id)});
        });
    }
    viewDayType(id){
        this.props.history.push(`/view-dayType/${id}`);
    }
    editDayType(id){
        this.props.history.push(`/add-dayType/${id}`);
    }

    componentDidMount(){
        DayTypeService.getDayTypes().then((res) => {
            this.setState({ dayTypes: res.data});
        });
    }

    addDayType(){
        this.props.history.push('/add-dayType/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DayType List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDayType}> Add DayType</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dayTypes.map(
                                        dayType => 
                                        <tr key = {dayType.dayTypeId}>
                                             <td>
                                                 <button onClick={ () => this.editDayType(dayType.dayTypeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDayType(dayType.dayTypeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDayType(dayType.dayTypeId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListDayTypeComponent
