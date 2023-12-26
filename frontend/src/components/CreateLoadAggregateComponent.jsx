import React, { Component } from 'react'
import LoadAggregateService from '../services/LoadAggregateService';

class CreateLoadAggregateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LoadAggregateService.getLoadAggregateById(this.state.id).then( (res) =>{
                let loadAggregate = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadAggregate = (e) => {
        e.preventDefault();
        let loadAggregate = {
                loadAggregateId: this.state.id,
            };
        console.log('loadAggregate => ' + JSON.stringify(loadAggregate));

        // step 5
        if(this.state.id === '_add'){
            loadAggregate.loadAggregateId=''
            LoadAggregateService.createLoadAggregate(loadAggregate).then(res =>{
                this.props.history.push('/loadAggregates');
            });
        }else{
            LoadAggregateService.updateLoadAggregate(loadAggregate).then( res => {
                this.props.history.push('/loadAggregates');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadAggregates');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadAggregate</h3>
        }else{
            return <h3 className="text-center">Update LoadAggregate</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadAggregate}>Save</button>
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

export default CreateLoadAggregateComponent
