import React, { Component } from 'react'
import LineService from '../services/LineService';

class CreateLineComponent extends Component {
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
            LineService.getLineById(this.state.id).then( (res) =>{
                let line = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLine = (e) => {
        e.preventDefault();
        let line = {
                lineId: this.state.id,
            };
        console.log('line => ' + JSON.stringify(line));

        // step 5
        if(this.state.id === '_add'){
            line.lineId=''
            LineService.createLine(line).then(res =>{
                this.props.history.push('/lines');
            });
        }else{
            LineService.updateLine(line).then( res => {
                this.props.history.push('/lines');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/lines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Line</h3>
        }else{
            return <h3 className="text-center">Update Line</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLine}>Save</button>
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

export default CreateLineComponent
