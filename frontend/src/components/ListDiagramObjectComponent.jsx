import React, { Component } from 'react'
import DiagramObjectService from '../services/DiagramObjectService'

class ListDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramObjects: []
        }
        this.addDiagramObject = this.addDiagramObject.bind(this);
        this.editDiagramObject = this.editDiagramObject.bind(this);
        this.deleteDiagramObject = this.deleteDiagramObject.bind(this);
    }

    deleteDiagramObject(id){
        DiagramObjectService.deleteDiagramObject(id).then( res => {
            this.setState({diagramObjects: this.state.diagramObjects.filter(diagramObject => diagramObject.diagramObjectId !== id)});
        });
    }
    viewDiagramObject(id){
        this.props.history.push(`/view-diagramObject/${id}`);
    }
    editDiagramObject(id){
        this.props.history.push(`/add-diagramObject/${id}`);
    }

    componentDidMount(){
        DiagramObjectService.getDiagramObjects().then((res) => {
            this.setState({ diagramObjects: res.data});
        });
    }

    addDiagramObject(){
        this.props.history.push('/add-diagramObject/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramObject List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramObject}> Add DiagramObject</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DrawingOrder </th>
                                    <th> IsPolygon </th>
                                    <th> OffsetX </th>
                                    <th> OffsetY </th>
                                    <th> Rotation </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.diagramObjects.map(
                                        diagramObject => 
                                        <tr key = {diagramObject.diagramObjectId}>
                                             <td> { diagramObject.drawingOrder } </td>
                                             <td> { diagramObject.isPolygon } </td>
                                             <td> { diagramObject.offsetX } </td>
                                             <td> { diagramObject.offsetY } </td>
                                             <td> { diagramObject.rotation } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiagramObject(diagramObject.diagramObjectId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramObject(diagramObject.diagramObjectId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramObject(diagramObject.diagramObjectId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramObjectComponent
