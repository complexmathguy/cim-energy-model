import React, { Component } from 'react'
import StaticpowersystemmodelService from '../services/StaticpowersystemmodelService'

class ListStaticpowersystemmodelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                staticpowersystemmodels: []
        }
        this.addStaticpowersystemmodel = this.addStaticpowersystemmodel.bind(this);
        this.editStaticpowersystemmodel = this.editStaticpowersystemmodel.bind(this);
        this.deleteStaticpowersystemmodel = this.deleteStaticpowersystemmodel.bind(this);
    }

    deleteStaticpowersystemmodel(id){
        StaticpowersystemmodelService.deleteStaticpowersystemmodel(id).then( res => {
            this.setState({staticpowersystemmodels: this.state.staticpowersystemmodels.filter(staticpowersystemmodel => staticpowersystemmodel.staticpowersystemmodelId !== id)});
        });
    }
    viewStaticpowersystemmodel(id){
        this.props.history.push(`/view-staticpowersystemmodel/${id}`);
    }
    editStaticpowersystemmodel(id){
        this.props.history.push(`/add-staticpowersystemmodel/${id}`);
    }

    componentDidMount(){
        StaticpowersystemmodelService.getStaticpowersystemmodels().then((res) => {
            this.setState({ staticpowersystemmodels: res.data});
        });
    }

    addStaticpowersystemmodel(){
        this.props.history.push('/add-staticpowersystemmodel/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Staticpowersystemmodel List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStaticpowersystemmodel}> Add Staticpowersystemmodel</button>
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
                                    this.state.staticpowersystemmodels.map(
                                        staticpowersystemmodel => 
                                        <tr key = {staticpowersystemmodel.staticpowersystemmodelId}>
                                             <td>
                                                 <button onClick={ () => this.editStaticpowersystemmodel(staticpowersystemmodel.staticpowersystemmodelId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStaticpowersystemmodel(staticpowersystemmodel.staticpowersystemmodelId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStaticpowersystemmodel(staticpowersystemmodel.staticpowersystemmodelId)} className="btn btn-info btn-sm">View </button>
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

export default ListStaticpowersystemmodelComponent
