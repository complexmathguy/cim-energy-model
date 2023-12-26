import React, { Component } from 'react'
import DCLineSegmentService from '../services/DCLineSegmentService'

class ListDCLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCLineSegments: []
        }
        this.addDCLineSegment = this.addDCLineSegment.bind(this);
        this.editDCLineSegment = this.editDCLineSegment.bind(this);
        this.deleteDCLineSegment = this.deleteDCLineSegment.bind(this);
    }

    deleteDCLineSegment(id){
        DCLineSegmentService.deleteDCLineSegment(id).then( res => {
            this.setState({dCLineSegments: this.state.dCLineSegments.filter(dCLineSegment => dCLineSegment.dCLineSegmentId !== id)});
        });
    }
    viewDCLineSegment(id){
        this.props.history.push(`/view-dCLineSegment/${id}`);
    }
    editDCLineSegment(id){
        this.props.history.push(`/add-dCLineSegment/${id}`);
    }

    componentDidMount(){
        DCLineSegmentService.getDCLineSegments().then((res) => {
            this.setState({ dCLineSegments: res.data});
        });
    }

    addDCLineSegment(){
        this.props.history.push('/add-dCLineSegment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCLineSegment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCLineSegment}> Add DCLineSegment</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Capacitance </th>
                                    <th> Inductance </th>
                                    <th> Length </th>
                                    <th> Resistance </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dCLineSegments.map(
                                        dCLineSegment => 
                                        <tr key = {dCLineSegment.dCLineSegmentId}>
                                             <td> { dCLineSegment.capacitance } </td>
                                             <td> { dCLineSegment.inductance } </td>
                                             <td> { dCLineSegment.length } </td>
                                             <td> { dCLineSegment.resistance } </td>
                                             <td>
                                                 <button onClick={ () => this.editDCLineSegment(dCLineSegment.dCLineSegmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCLineSegment(dCLineSegment.dCLineSegmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCLineSegment(dCLineSegment.dCLineSegmentId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCLineSegmentComponent
