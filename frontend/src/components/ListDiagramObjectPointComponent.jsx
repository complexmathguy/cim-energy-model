import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService'

class ListDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramObjectPoints: []
        }
        this.addDiagramObjectPoint = this.addDiagramObjectPoint.bind(this);
        this.editDiagramObjectPoint = this.editDiagramObjectPoint.bind(this);
        this.deleteDiagramObjectPoint = this.deleteDiagramObjectPoint.bind(this);
    }

    deleteDiagramObjectPoint(id){
        DiagramObjectPointService.deleteDiagramObjectPoint(id).then( res => {
            this.setState({diagramObjectPoints: this.state.diagramObjectPoints.filter(diagramObjectPoint => diagramObjectPoint.diagramObjectPointId !== id)});
        });
    }
    viewDiagramObjectPoint(id){
        this.props.history.push(`/view-diagramObjectPoint/${id}`);
    }
    editDiagramObjectPoint(id){
        this.props.history.push(`/add-diagramObjectPoint/${id}`);
    }

    componentDidMount(){
        DiagramObjectPointService.getDiagramObjectPoints().then((res) => {
            this.setState({ diagramObjectPoints: res.data});
        });
    }

    addDiagramObjectPoint(){
        this.props.history.push('/add-diagramObjectPoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramObjectPoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramObjectPoint}> Add DiagramObjectPoint</button>
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
                                    this.state.diagramObjectPoints.map(
                                        diagramObjectPoint => 
                                        <tr key = {diagramObjectPoint.diagramObjectPointId}>
                                             <td> { diagramObjectPoint.sequenceNumber } </td>
                                             <td> { diagramObjectPoint.xPosition } </td>
                                             <td> { diagramObjectPoint.yPosition } </td>
                                             <td> { diagramObjectPoint.zPosition } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiagramObjectPoint(diagramObjectPoint.diagramObjectPointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramObjectPoint(diagramObjectPoint.diagramObjectPointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramObjectPoint(diagramObjectPoint.diagramObjectPointId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramObjectPointComponent
