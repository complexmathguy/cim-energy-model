import React, { Component } from 'react'
import DiagramObjectStyleService from '../services/DiagramObjectStyleService'

class ListDiagramObjectStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramObjectStyles: []
        }
        this.addDiagramObjectStyle = this.addDiagramObjectStyle.bind(this);
        this.editDiagramObjectStyle = this.editDiagramObjectStyle.bind(this);
        this.deleteDiagramObjectStyle = this.deleteDiagramObjectStyle.bind(this);
    }

    deleteDiagramObjectStyle(id){
        DiagramObjectStyleService.deleteDiagramObjectStyle(id).then( res => {
            this.setState({diagramObjectStyles: this.state.diagramObjectStyles.filter(diagramObjectStyle => diagramObjectStyle.diagramObjectStyleId !== id)});
        });
    }
    viewDiagramObjectStyle(id){
        this.props.history.push(`/view-diagramObjectStyle/${id}`);
    }
    editDiagramObjectStyle(id){
        this.props.history.push(`/add-diagramObjectStyle/${id}`);
    }

    componentDidMount(){
        DiagramObjectStyleService.getDiagramObjectStyles().then((res) => {
            this.setState({ diagramObjectStyles: res.data});
        });
    }

    addDiagramObjectStyle(){
        this.props.history.push('/add-diagramObjectStyle/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramObjectStyle List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramObjectStyle}> Add DiagramObjectStyle</button>
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
                                    this.state.diagramObjectStyles.map(
                                        diagramObjectStyle => 
                                        <tr key = {diagramObjectStyle.diagramObjectStyleId}>
                                             <td>
                                                 <button onClick={ () => this.editDiagramObjectStyle(diagramObjectStyle.diagramObjectStyleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramObjectStyle(diagramObjectStyle.diagramObjectStyleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramObjectStyle(diagramObjectStyle.diagramObjectStyleId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramObjectStyleComponent
