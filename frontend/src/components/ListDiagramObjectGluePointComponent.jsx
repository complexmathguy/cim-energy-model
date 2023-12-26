import React, { Component } from 'react'
import DiagramObjectGluePointService from '../services/DiagramObjectGluePointService'

class ListDiagramObjectGluePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramObjectGluePoints: []
        }
        this.addDiagramObjectGluePoint = this.addDiagramObjectGluePoint.bind(this);
        this.editDiagramObjectGluePoint = this.editDiagramObjectGluePoint.bind(this);
        this.deleteDiagramObjectGluePoint = this.deleteDiagramObjectGluePoint.bind(this);
    }

    deleteDiagramObjectGluePoint(id){
        DiagramObjectGluePointService.deleteDiagramObjectGluePoint(id).then( res => {
            this.setState({diagramObjectGluePoints: this.state.diagramObjectGluePoints.filter(diagramObjectGluePoint => diagramObjectGluePoint.diagramObjectGluePointId !== id)});
        });
    }
    viewDiagramObjectGluePoint(id){
        this.props.history.push(`/view-diagramObjectGluePoint/${id}`);
    }
    editDiagramObjectGluePoint(id){
        this.props.history.push(`/add-diagramObjectGluePoint/${id}`);
    }

    componentDidMount(){
        DiagramObjectGluePointService.getDiagramObjectGluePoints().then((res) => {
            this.setState({ diagramObjectGluePoints: res.data});
        });
    }

    addDiagramObjectGluePoint(){
        this.props.history.push('/add-diagramObjectGluePoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramObjectGluePoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramObjectGluePoint}> Add DiagramObjectGluePoint</button>
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
                                    this.state.diagramObjectGluePoints.map(
                                        diagramObjectGluePoint => 
                                        <tr key = {diagramObjectGluePoint.diagramObjectGluePointId}>
                                             <td>
                                                 <button onClick={ () => this.editDiagramObjectGluePoint(diagramObjectGluePoint.diagramObjectGluePointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramObjectGluePoint(diagramObjectGluePoint.diagramObjectGluePointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramObjectGluePoint(diagramObjectGluePoint.diagramObjectGluePointId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramObjectGluePointComponent
