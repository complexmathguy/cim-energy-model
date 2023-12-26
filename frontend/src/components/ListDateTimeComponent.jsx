import React, { Component } from 'react'
import DateTimeService from '../services/DateTimeService'

class ListDateTimeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dateTimes: []
        }
        this.addDateTime = this.addDateTime.bind(this);
        this.editDateTime = this.editDateTime.bind(this);
        this.deleteDateTime = this.deleteDateTime.bind(this);
    }

    deleteDateTime(id){
        DateTimeService.deleteDateTime(id).then( res => {
            this.setState({dateTimes: this.state.dateTimes.filter(dateTime => dateTime.dateTimeId !== id)});
        });
    }
    viewDateTime(id){
        this.props.history.push(`/view-dateTime/${id}`);
    }
    editDateTime(id){
        this.props.history.push(`/add-dateTime/${id}`);
    }

    componentDidMount(){
        DateTimeService.getDateTimes().then((res) => {
            this.setState({ dateTimes: res.data});
        });
    }

    addDateTime(){
        this.props.history.push('/add-dateTime/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DateTime List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDateTime}> Add DateTime</button>
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
                                    this.state.dateTimes.map(
                                        dateTime => 
                                        <tr key = {dateTime.dateTimeId}>
                                             <td>
                                                 <button onClick={ () => this.editDateTime(dateTime.dateTimeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDateTime(dateTime.dateTimeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDateTime(dateTime.dateTimeId)} className="btn btn-info btn-sm">View </button>
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

export default ListDateTimeComponent
