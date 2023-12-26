import React, { Component } from 'react'
import NonConformLoadService from '../services/NonConformLoadService'

class ListNonConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nonConformLoads: []
        }
        this.addNonConformLoad = this.addNonConformLoad.bind(this);
        this.editNonConformLoad = this.editNonConformLoad.bind(this);
        this.deleteNonConformLoad = this.deleteNonConformLoad.bind(this);
    }

    deleteNonConformLoad(id){
        NonConformLoadService.deleteNonConformLoad(id).then( res => {
            this.setState({nonConformLoads: this.state.nonConformLoads.filter(nonConformLoad => nonConformLoad.nonConformLoadId !== id)});
        });
    }
    viewNonConformLoad(id){
        this.props.history.push(`/view-nonConformLoad/${id}`);
    }
    editNonConformLoad(id){
        this.props.history.push(`/add-nonConformLoad/${id}`);
    }

    componentDidMount(){
        NonConformLoadService.getNonConformLoads().then((res) => {
            this.setState({ nonConformLoads: res.data});
        });
    }

    addNonConformLoad(){
        this.props.history.push('/add-nonConformLoad/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NonConformLoad List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNonConformLoad}> Add NonConformLoad</button>
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
                                    this.state.nonConformLoads.map(
                                        nonConformLoad => 
                                        <tr key = {nonConformLoad.nonConformLoadId}>
                                             <td>
                                                 <button onClick={ () => this.editNonConformLoad(nonConformLoad.nonConformLoadId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNonConformLoad(nonConformLoad.nonConformLoadId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNonConformLoad(nonConformLoad.nonConformLoadId)} className="btn btn-info btn-sm">View </button>
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

export default ListNonConformLoadComponent
