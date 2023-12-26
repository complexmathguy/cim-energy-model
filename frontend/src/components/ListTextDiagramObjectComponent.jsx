import React, { Component } from 'react'
import TextDiagramObjectService from '../services/TextDiagramObjectService'

class ListTextDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                textDiagramObjects: []
        }
        this.addTextDiagramObject = this.addTextDiagramObject.bind(this);
        this.editTextDiagramObject = this.editTextDiagramObject.bind(this);
        this.deleteTextDiagramObject = this.deleteTextDiagramObject.bind(this);
    }

    deleteTextDiagramObject(id){
        TextDiagramObjectService.deleteTextDiagramObject(id).then( res => {
            this.setState({textDiagramObjects: this.state.textDiagramObjects.filter(textDiagramObject => textDiagramObject.textDiagramObjectId !== id)});
        });
    }
    viewTextDiagramObject(id){
        this.props.history.push(`/view-textDiagramObject/${id}`);
    }
    editTextDiagramObject(id){
        this.props.history.push(`/add-textDiagramObject/${id}`);
    }

    componentDidMount(){
        TextDiagramObjectService.getTextDiagramObjects().then((res) => {
            this.setState({ textDiagramObjects: res.data});
        });
    }

    addTextDiagramObject(){
        this.props.history.push('/add-textDiagramObject/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TextDiagramObject List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTextDiagramObject}> Add TextDiagramObject</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Text </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.textDiagramObjects.map(
                                        textDiagramObject => 
                                        <tr key = {textDiagramObject.textDiagramObjectId}>
                                             <td> { textDiagramObject.text } </td>
                                             <td>
                                                 <button onClick={ () => this.editTextDiagramObject(textDiagramObject.textDiagramObjectId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTextDiagramObject(textDiagramObject.textDiagramObjectId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTextDiagramObject(textDiagramObject.textDiagramObjectId)} className="btn btn-info btn-sm">View </button>
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

export default ListTextDiagramObjectComponent
