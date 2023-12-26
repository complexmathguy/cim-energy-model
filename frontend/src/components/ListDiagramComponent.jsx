import React, { Component } from 'react'
import DiagramService from '../services/DiagramService'

class ListDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagrams: []
        }
        this.addDiagram = this.addDiagram.bind(this);
        this.editDiagram = this.editDiagram.bind(this);
        this.deleteDiagram = this.deleteDiagram.bind(this);
    }

    deleteDiagram(id){
        DiagramService.deleteDiagram(id).then( res => {
            this.setState({diagrams: this.state.diagrams.filter(diagram => diagram.diagramId !== id)});
        });
    }
    viewDiagram(id){
        this.props.history.push(`/view-diagram/${id}`);
    }
    editDiagram(id){
        this.props.history.push(`/add-diagram/${id}`);
    }

    componentDidMount(){
        DiagramService.getDiagrams().then((res) => {
            this.setState({ diagrams: res.data});
        });
    }

    addDiagram(){
        this.props.history.push('/add-diagram/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Diagram List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagram}> Add Diagram</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Orientation </th>
                                    <th> X1InitialView </th>
                                    <th> X2InitialView </th>
                                    <th> Y1InitialView </th>
                                    <th> Y2InitialView </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.diagrams.map(
                                        diagram => 
                                        <tr key = {diagram.diagramId}>
                                             <td> { diagram.orientation } </td>
                                             <td> { diagram.x1InitialView } </td>
                                             <td> { diagram.x2InitialView } </td>
                                             <td> { diagram.y1InitialView } </td>
                                             <td> { diagram.y2InitialView } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiagram(diagram.diagramId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagram(diagram.diagramId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagram(diagram.diagramId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramComponent
