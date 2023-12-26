import React, { Component } from 'react'
import RegularTimePointService from '../services/RegularTimePointService'

class ListRegularTimePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                regularTimePoints: []
        }
        this.addRegularTimePoint = this.addRegularTimePoint.bind(this);
        this.editRegularTimePoint = this.editRegularTimePoint.bind(this);
        this.deleteRegularTimePoint = this.deleteRegularTimePoint.bind(this);
    }

    deleteRegularTimePoint(id){
        RegularTimePointService.deleteRegularTimePoint(id).then( res => {
            this.setState({regularTimePoints: this.state.regularTimePoints.filter(regularTimePoint => regularTimePoint.regularTimePointId !== id)});
        });
    }
    viewRegularTimePoint(id){
        this.props.history.push(`/view-regularTimePoint/${id}`);
    }
    editRegularTimePoint(id){
        this.props.history.push(`/add-regularTimePoint/${id}`);
    }

    componentDidMount(){
        RegularTimePointService.getRegularTimePoints().then((res) => {
            this.setState({ regularTimePoints: res.data});
        });
    }

    addRegularTimePoint(){
        this.props.history.push('/add-regularTimePoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RegularTimePoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRegularTimePoint}> Add RegularTimePoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> SequenceNumber </th>
                                    <th> Value1 </th>
                                    <th> Value2 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.regularTimePoints.map(
                                        regularTimePoint => 
                                        <tr key = {regularTimePoint.regularTimePointId}>
                                             <td> { regularTimePoint.sequenceNumber } </td>
                                             <td> { regularTimePoint.value1 } </td>
                                             <td> { regularTimePoint.value2 } </td>
                                             <td>
                                                 <button onClick={ () => this.editRegularTimePoint(regularTimePoint.regularTimePointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRegularTimePoint(regularTimePoint.regularTimePointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRegularTimePoint(regularTimePoint.regularTimePointId)} className="btn btn-info btn-sm">View </button>
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

export default ListRegularTimePointComponent
