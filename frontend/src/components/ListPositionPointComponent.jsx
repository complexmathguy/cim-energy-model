import React, { Component } from 'react'
import PositionPointService from '../services/PositionPointService'

class ListPositionPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                positionPoints: []
        }
        this.addPositionPoint = this.addPositionPoint.bind(this);
        this.editPositionPoint = this.editPositionPoint.bind(this);
        this.deletePositionPoint = this.deletePositionPoint.bind(this);
    }

    deletePositionPoint(id){
        PositionPointService.deletePositionPoint(id).then( res => {
            this.setState({positionPoints: this.state.positionPoints.filter(positionPoint => positionPoint.positionPointId !== id)});
        });
    }
    viewPositionPoint(id){
        this.props.history.push(`/view-positionPoint/${id}`);
    }
    editPositionPoint(id){
        this.props.history.push(`/add-positionPoint/${id}`);
    }

    componentDidMount(){
        PositionPointService.getPositionPoints().then((res) => {
            this.setState({ positionPoints: res.data});
        });
    }

    addPositionPoint(){
        this.props.history.push('/add-positionPoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PositionPoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPositionPoint}> Add PositionPoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> SequenceNumber </th>
                                    <th> XPosition </th>
                                    <th> YPosition </th>
                                    <th> ZPosition </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.positionPoints.map(
                                        positionPoint => 
                                        <tr key = {positionPoint.positionPointId}>
                                             <td> { positionPoint.sequenceNumber } </td>
                                             <td> { positionPoint.xPosition } </td>
                                             <td> { positionPoint.yPosition } </td>
                                             <td> { positionPoint.zPosition } </td>
                                             <td>
                                                 <button onClick={ () => this.editPositionPoint(positionPoint.positionPointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePositionPoint(positionPoint.positionPointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPositionPoint(positionPoint.positionPointId)} className="btn btn-info btn-sm">View </button>
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

export default ListPositionPointComponent
