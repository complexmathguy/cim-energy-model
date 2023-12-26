import React, { Component } from 'react'
import BreakerService from '../services/BreakerService';

class CreateBreakerComponent extends Component {
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
            BreakerService.getBreakerById(this.state.id).then( (res) =>{
                let breaker = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateBreaker = (e) => {
        e.preventDefault();
        let breaker = {
                breakerId: this.state.id,
            };
        console.log('breaker => ' + JSON.stringify(breaker));

        // step 5
        if(this.state.id === '_add'){
            breaker.breakerId=''
            BreakerService.createBreaker(breaker).then(res =>{
                this.props.history.push('/breakers');
            });
        }else{
            BreakerService.updateBreaker(breaker).then( res => {
                this.props.history.push('/breakers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/breakers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Breaker</h3>
        }else{
            return <h3 className="text-center">Update Breaker</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBreaker}>Save</button>
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

export default CreateBreakerComponent
