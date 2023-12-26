import React, { Component } from 'react'
import ConformLoadService from '../services/ConformLoadService'

class ListConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conformLoads: []
        }
        this.addConformLoad = this.addConformLoad.bind(this);
        this.editConformLoad = this.editConformLoad.bind(this);
        this.deleteConformLoad = this.deleteConformLoad.bind(this);
    }

    deleteConformLoad(id){
        ConformLoadService.deleteConformLoad(id).then( res => {
            this.setState({conformLoads: this.state.conformLoads.filter(conformLoad => conformLoad.conformLoadId !== id)});
        });
    }
    viewConformLoad(id){
        this.props.history.push(`/view-conformLoad/${id}`);
    }
    editConformLoad(id){
        this.props.history.push(`/add-conformLoad/${id}`);
    }

    componentDidMount(){
        ConformLoadService.getConformLoads().then((res) => {
            this.setState({ conformLoads: res.data});
        });
    }

    addConformLoad(){
        this.props.history.push('/add-conformLoad/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConformLoad List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConformLoad}> Add ConformLoad</button>
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
                                    this.state.conformLoads.map(
                                        conformLoad => 
                                        <tr key = {conformLoad.conformLoadId}>
                                             <td>
                                                 <button onClick={ () => this.editConformLoad(conformLoad.conformLoadId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConformLoad(conformLoad.conformLoadId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConformLoad(conformLoad.conformLoadId)} className="btn btn-info btn-sm">View </button>
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

export default ListConformLoadComponent
