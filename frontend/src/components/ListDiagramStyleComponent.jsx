import React, { Component } from 'react'
import DiagramStyleService from '../services/DiagramStyleService'

class ListDiagramStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramStyles: []
        }
        this.addDiagramStyle = this.addDiagramStyle.bind(this);
        this.editDiagramStyle = this.editDiagramStyle.bind(this);
        this.deleteDiagramStyle = this.deleteDiagramStyle.bind(this);
    }

    deleteDiagramStyle(id){
        DiagramStyleService.deleteDiagramStyle(id).then( res => {
            this.setState({diagramStyles: this.state.diagramStyles.filter(diagramStyle => diagramStyle.diagramStyleId !== id)});
        });
    }
    viewDiagramStyle(id){
        this.props.history.push(`/view-diagramStyle/${id}`);
    }
    editDiagramStyle(id){
        this.props.history.push(`/add-diagramStyle/${id}`);
    }

    componentDidMount(){
        DiagramStyleService.getDiagramStyles().then((res) => {
            this.setState({ diagramStyles: res.data});
        });
    }

    addDiagramStyle(){
        this.props.history.push('/add-diagramStyle/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramStyle List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramStyle}> Add DiagramStyle</button>
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
                                    this.state.diagramStyles.map(
                                        diagramStyle => 
                                        <tr key = {diagramStyle.diagramStyleId}>
                                             <td>
                                                 <button onClick={ () => this.editDiagramStyle(diagramStyle.diagramStyleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramStyle(diagramStyle.diagramStyleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramStyle(diagramStyle.diagramStyleId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramStyleComponent
