import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService'

class ListSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                seriesCompensators: []
        }
        this.addSeriesCompensator = this.addSeriesCompensator.bind(this);
        this.editSeriesCompensator = this.editSeriesCompensator.bind(this);
        this.deleteSeriesCompensator = this.deleteSeriesCompensator.bind(this);
    }

    deleteSeriesCompensator(id){
        SeriesCompensatorService.deleteSeriesCompensator(id).then( res => {
            this.setState({seriesCompensators: this.state.seriesCompensators.filter(seriesCompensator => seriesCompensator.seriesCompensatorId !== id)});
        });
    }
    viewSeriesCompensator(id){
        this.props.history.push(`/view-seriesCompensator/${id}`);
    }
    editSeriesCompensator(id){
        this.props.history.push(`/add-seriesCompensator/${id}`);
    }

    componentDidMount(){
        SeriesCompensatorService.getSeriesCompensators().then((res) => {
            this.setState({ seriesCompensators: res.data});
        });
    }

    addSeriesCompensator(){
        this.props.history.push('/add-seriesCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SeriesCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSeriesCompensator}> Add SeriesCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> R </th>
                                    <th> R0 </th>
                                    <th> VaristorPresent </th>
                                    <th> VaristorRatedCurrent </th>
                                    <th> VaristorVoltageThreshold </th>
                                    <th> X </th>
                                    <th> X0 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.seriesCompensators.map(
                                        seriesCompensator => 
                                        <tr key = {seriesCompensator.seriesCompensatorId}>
                                             <td> { seriesCompensator.r } </td>
                                             <td> { seriesCompensator.r0 } </td>
                                             <td> { seriesCompensator.varistorPresent } </td>
                                             <td> { seriesCompensator.varistorRatedCurrent } </td>
                                             <td> { seriesCompensator.varistorVoltageThreshold } </td>
                                             <td> { seriesCompensator.x } </td>
                                             <td> { seriesCompensator.x0 } </td>
                                             <td>
                                                 <button onClick={ () => this.editSeriesCompensator(seriesCompensator.seriesCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSeriesCompensator(seriesCompensator.seriesCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSeriesCompensator(seriesCompensator.seriesCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListSeriesCompensatorComponent
