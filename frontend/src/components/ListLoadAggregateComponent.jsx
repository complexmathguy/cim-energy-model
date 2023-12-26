import React, { Component } from 'react'
import LoadAggregateService from '../services/LoadAggregateService'

class ListLoadAggregateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadAggregates: []
        }
        this.addLoadAggregate = this.addLoadAggregate.bind(this);
        this.editLoadAggregate = this.editLoadAggregate.bind(this);
        this.deleteLoadAggregate = this.deleteLoadAggregate.bind(this);
    }

    deleteLoadAggregate(id){
        LoadAggregateService.deleteLoadAggregate(id).then( res => {
            this.setState({loadAggregates: this.state.loadAggregates.filter(loadAggregate => loadAggregate.loadAggregateId !== id)});
        });
    }
    viewLoadAggregate(id){
        this.props.history.push(`/view-loadAggregate/${id}`);
    }
    editLoadAggregate(id){
        this.props.history.push(`/add-loadAggregate/${id}`);
    }

    componentDidMount(){
        LoadAggregateService.getLoadAggregates().then((res) => {
            this.setState({ loadAggregates: res.data});
        });
    }

    addLoadAggregate(){
        this.props.history.push('/add-loadAggregate/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadAggregate List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadAggregate}> Add LoadAggregate</button>
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
                                    this.state.loadAggregates.map(
                                        loadAggregate => 
                                        <tr key = {loadAggregate.loadAggregateId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadAggregate(loadAggregate.loadAggregateId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadAggregate(loadAggregate.loadAggregateId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadAggregate(loadAggregate.loadAggregateId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadAggregateComponent
