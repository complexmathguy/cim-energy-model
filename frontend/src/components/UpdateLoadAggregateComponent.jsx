import React, { Component } from 'react'
import LoadAggregateService from '../services/LoadAggregateService';

class UpdateLoadAggregateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadAggregate = this.updateLoadAggregate.bind(this);

    }

    componentDidMount(){
        LoadAggregateService.getLoadAggregateById(this.state.id).then( (res) =>{
            let loadAggregate = res.data;
            this.setState({
            });
        });
    }

    updateLoadAggregate = (e) => {
        e.preventDefault();
        let loadAggregate = {
            loadAggregateId: this.state.id,
        };
        console.log('loadAggregate => ' + JSON.stringify(loadAggregate));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadAggregateService.updateLoadAggregate(loadAggregate).then( res => {
            this.props.history.push('/loadAggregates');
        });
    }


    cancel(){
        this.props.history.push('/loadAggregates');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadAggregate</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadAggregate}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateLoadAggregateComponent
