import React, { Component } from 'react'
import LimitService from '../services/LimitService';

class CreateLimitComponent extends Component {
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
            LimitService.getLimitById(this.state.id).then( (res) =>{
                let limit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLimit = (e) => {
        e.preventDefault();
        let limit = {
                limitId: this.state.id,
            };
        console.log('limit => ' + JSON.stringify(limit));

        // step 5
        if(this.state.id === '_add'){
            limit.limitId=''
            LimitService.createLimit(limit).then(res =>{
                this.props.history.push('/limits');
            });
        }else{
            LimitService.updateLimit(limit).then( res => {
                this.props.history.push('/limits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/limits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Limit</h3>
        }else{
            return <h3 className="text-center">Update Limit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLimit}>Save</button>
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

export default CreateLimitComponent
