import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService'

class ListNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nonlinearShuntCompensatorPoints: []
        }
        this.addNonlinearShuntCompensatorPoint = this.addNonlinearShuntCompensatorPoint.bind(this);
        this.editNonlinearShuntCompensatorPoint = this.editNonlinearShuntCompensatorPoint.bind(this);
        this.deleteNonlinearShuntCompensatorPoint = this.deleteNonlinearShuntCompensatorPoint.bind(this);
    }

    deleteNonlinearShuntCompensatorPoint(id){
        NonlinearShuntCompensatorPointService.deleteNonlinearShuntCompensatorPoint(id).then( res => {
            this.setState({nonlinearShuntCompensatorPoints: this.state.nonlinearShuntCompensatorPoints.filter(nonlinearShuntCompensatorPoint => nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId !== id)});
        });
    }
    viewNonlinearShuntCompensatorPoint(id){
        this.props.history.push(`/view-nonlinearShuntCompensatorPoint/${id}`);
    }
    editNonlinearShuntCompensatorPoint(id){
        this.props.history.push(`/add-nonlinearShuntCompensatorPoint/${id}`);
    }

    componentDidMount(){
        NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPoints().then((res) => {
            this.setState({ nonlinearShuntCompensatorPoints: res.data});
        });
    }

    addNonlinearShuntCompensatorPoint(){
        this.props.history.push('/add-nonlinearShuntCompensatorPoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NonlinearShuntCompensatorPoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNonlinearShuntCompensatorPoint}> Add NonlinearShuntCompensatorPoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> B </th>
                                    <th> B0 </th>
                                    <th> G </th>
                                    <th> G0 </th>
                                    <th> SectionNumber </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.nonlinearShuntCompensatorPoints.map(
                                        nonlinearShuntCompensatorPoint => 
                                        <tr key = {nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId}>
                                             <td> { nonlinearShuntCompensatorPoint.b } </td>
                                             <td> { nonlinearShuntCompensatorPoint.b0 } </td>
                                             <td> { nonlinearShuntCompensatorPoint.g } </td>
                                             <td> { nonlinearShuntCompensatorPoint.g0 } </td>
                                             <td> { nonlinearShuntCompensatorPoint.sectionNumber } </td>
                                             <td>
                                                 <button onClick={ () => this.editNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId)} className="btn btn-info btn-sm">View </button>
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

export default ListNonlinearShuntCompensatorPointComponent
