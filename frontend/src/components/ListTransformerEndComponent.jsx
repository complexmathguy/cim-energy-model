import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService'

class ListTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                transformerEnds: []
        }
        this.addTransformerEnd = this.addTransformerEnd.bind(this);
        this.editTransformerEnd = this.editTransformerEnd.bind(this);
        this.deleteTransformerEnd = this.deleteTransformerEnd.bind(this);
    }

    deleteTransformerEnd(id){
        TransformerEndService.deleteTransformerEnd(id).then( res => {
            this.setState({transformerEnds: this.state.transformerEnds.filter(transformerEnd => transformerEnd.transformerEndId !== id)});
        });
    }
    viewTransformerEnd(id){
        this.props.history.push(`/view-transformerEnd/${id}`);
    }
    editTransformerEnd(id){
        this.props.history.push(`/add-transformerEnd/${id}`);
    }

    componentDidMount(){
        TransformerEndService.getTransformerEnds().then((res) => {
            this.setState({ transformerEnds: res.data});
        });
    }

    addTransformerEnd(){
        this.props.history.push('/add-transformerEnd/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TransformerEnd List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTransformerEnd}> Add TransformerEnd</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EndNumber </th>
                                    <th> Grounded </th>
                                    <th> Rground </th>
                                    <th> Xground </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.transformerEnds.map(
                                        transformerEnd => 
                                        <tr key = {transformerEnd.transformerEndId}>
                                             <td> { transformerEnd.endNumber } </td>
                                             <td> { transformerEnd.grounded } </td>
                                             <td> { transformerEnd.rground } </td>
                                             <td> { transformerEnd.xground } </td>
                                             <td>
                                                 <button onClick={ () => this.editTransformerEnd(transformerEnd.transformerEndId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTransformerEnd(transformerEnd.transformerEndId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTransformerEnd(transformerEnd.transformerEndId)} className="btn btn-info btn-sm">View </button>
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

export default ListTransformerEndComponent
